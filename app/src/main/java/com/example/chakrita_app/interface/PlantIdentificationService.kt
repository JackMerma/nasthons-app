package com.example.chakrita_app.`interface`

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface PlantIdentificationService {
    @Multipart
    @POST("/v2/identify/{project}")
    suspend fun identifyPlant(
        @Path("project") project: String,
        @Query("include-related-images") includeRelatedImages: Boolean,
        @Query("no-reject") noReject: Boolean,
        @Query("nb-results") nbResults: Int,
        @Query("lang") lang: String,
        @Query("api-key") apiKey: String,
        @Part image: MultipartBody.Part,
        @Part("organs") organs: RequestBody
    ): PlantIdentificationResponse
}
