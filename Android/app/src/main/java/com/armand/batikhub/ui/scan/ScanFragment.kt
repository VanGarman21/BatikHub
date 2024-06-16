package com.armand.batikhub.ui.scan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.armand.batikhub.PredictionResultActivity
import com.armand.batikhub.api.ApiModule
import com.armand.batikhub.databinding.FragmentPindaiBinding
import com.armand.batikhub.model.PredictionResultResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

class ScanFragment : Fragment() {
    private var _binding: FragmentPindaiBinding? = null
    private val binding get() = _binding!!
    private var imageBitmap: Bitmap? = null

    private val cameraResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            imageBitmap = result.data?.extras?.get("data") as? Bitmap
            Log.d("Camera Result", "Bitmap from camera: $imageBitmap")
            binding.imgPreviewPhoto.setImageBitmap(imageBitmap)
        }
    }

    private val galleryResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = result.data?.data
            val imageStream = imageUri?.let { context?.contentResolver?.openInputStream(it) }
            imageBitmap = BitmapFactory.decodeStream(imageStream)
            Log.d("Gallery Result", "Bitmap from gallery: $imageBitmap")
            binding.imgPreviewPhoto.setImageBitmap(imageBitmap)
        }
    }

    private fun saveBitmapToFile(context: Context, bitmap: Bitmap?): File? {
        if (bitmap == null) {
            Log.e("Save Bitmap", "Bitmap is null")
            return null
        }

        val filename = "pindai_batik_temp.jpeg" // Pastikan ekstensi file sesuai
        val file = File(context.cacheDir, filename)
        file.createNewFile()

        val fOut = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut) // Pastikan format sesuai
        fOut.flush()
        fOut.close()

        Log.d("Save Bitmap", "File created with length: ${file.length()}")

        return file
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPindaiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraResultLauncher.launch(cameraIntent)
        }
        binding.buttonGallery.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryResultLauncher.launch(galleryIntent)
        }
        binding.buttonPindai.setOnClickListener {
            val file = saveBitmapToFile(requireContext(), imageBitmap)
            file?.let {
                val requestFile = it.asRequestBody("image/jpeg".toMediaTypeOrNull()) // Pastikan media type sesuai
                val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
                val call = ApiModule.batikApi.predictImage(body)
                call.enqueue(object : Callback<PredictionResultResponse> {
                    override fun onResponse(call: Call<PredictionResultResponse>, response: Response<PredictionResultResponse>) {
                        if (response.isSuccessful) {
                            val predictionResult = response.body()
                            Log.d("API Response", "Prediction result: $predictionResult")
                            val intent = Intent(context, PredictionResultActivity::class.java).apply {
                                putExtra("predictionResult", predictionResult)
                                val imageUri = FileProvider.getUriForFile(requireContext(), "${context?.packageName}.provider", file)
                                putExtra("imageUri", imageUri.toString())
                            }
                            startActivity(intent)
                        } else {
                            Log.e("API Error", "Response received but not successful: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<PredictionResultResponse>, t: Throwable) {
                        Log.e("API Error", "Call failed: ${t.message}")
                    }
                })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}