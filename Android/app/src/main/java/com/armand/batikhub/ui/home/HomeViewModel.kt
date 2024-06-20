import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armand.batikhub.api.ApiModule
import com.armand.batikhub.model.Batik
import com.armand.batikhub.model.BatikResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _batikList = MutableLiveData<List<Batik>>()
    val batikList: LiveData<List<Batik>> = _batikList

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun fetchBatik() {
        ApiModule.batikApi.getAllBatik().enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    _batikList.value = response.body()?.data ?: emptyList()
                    _message.value = "Batik berhasil dimuat"
                }
                else {
                    Log.e("HomeViewModel", "Failed to fetch batik: ${response.code()}")
                    _message.value = "Gagal memuat batik ${response.code()}"
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                // Handle failure
                Log.e("HomeViewModel", "Failed to fetch batik: ${t.message}")
                _message.value = "Gagal memuat batik ${t.message}"
            }
        })
    }

    fun searchBatikByName(name: String) {
        val requestBody = mapOf("name" to name)
        ApiModule.batikApi.getBatikByName(requestBody).enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    _batikList.value = response.body()?.data ?: emptyList()
                    Log.e("HomeViewModel", "Failed to fetch batik: ${response.code()}")
                    _message.value = "Batik dengan nama $name ditemukan"
                }
                else {
                    Log.e("HomeViewModel", "Failed to fetch batik: ${response.code()}")
                    _message.value = "Gagal menemukan batik ${response.code()}"
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                // Handle failure
                Log.e("HomeViewModel", "Failed to fetch batik: ${t.message}")
                _message.value = "Gagal menemukan batik ${t.message}"
            }
        })
    }
}