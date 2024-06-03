package com.armand.batikhub.ui.scan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.armand.batikhub.PredictionResultActivity
import com.armand.batikhub.databinding.FragmentPindaiBinding
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
            binding.imgPreviewPhoto.setImageBitmap(imageBitmap)
        }
    }

    private fun saveBitmapToFile(context: Context, bitmap: Bitmap?): Uri? {
        if (bitmap == null) return null

        val filename = "pindai_batik_temp.png"
        val file = File(context.cacheDir, filename)
        file.createNewFile()

        val fOut = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
        fOut.flush()
        fOut.close()

        return FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
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
            val imageUri = saveBitmapToFile(requireContext(), imageBitmap)
            val intent = Intent(context, PredictionResultActivity::class.java).apply {
                putExtra("imageUri", imageUri.toString())
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}