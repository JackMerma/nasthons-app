package com.example.chakrita_app.`interface`

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.example.chakrita_app.views.welcome.bitmapToFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
suspend fun uploadImageToApi(bitmap: Bitmap, context: Context) {
    val apiKey = "2b10wCLwPxID3U4shHnKMF6H"

    // Convertir Bitmap a File
    val file = bitmapToFile(bitmap, context)

    // Crear RequestBody para la imagen
    val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file)
    val body = MultipartBody.Part.createFormData("images", file.name, requestFile)

    // Crear RequestBody para el campo 'organs'
    val organs = RequestBody.create("text/plain".toMediaTypeOrNull(), "auto")

    // Configuración de Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-api.plantnet.org")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(PlantIdentificationService::class.java)

    // Manejar la llamada a la API en un CoroutineScope
    CoroutineScope(Dispatchers.IO).launch {
        try {
            // Llamada a la API directamente
            val identificationResult = service.identifyPlant(
                project = "all",
                includeRelatedImages = false,
                noReject = false,
                nbResults = 10,
                lang = "es",
                apiKey = apiKey,
                image = body,
                organs = organs
            )

            // Manejar el resultado de la identificación aquí
            Log.d("API Response", identificationResult.toString())
        } catch (e: Exception) {
            Log.e("Exception", e.message ?: "Error desconocido")
        }
        catch (e: HttpException) {
            Log.e("API Error", "Error en la respuesta: ${e.response()?.errorBody()?.string()}")
        } catch (e: Exception) {
            Log.e("API Error", "Error desconocido: ${e.localizedMessage}")
        }
    }
}
