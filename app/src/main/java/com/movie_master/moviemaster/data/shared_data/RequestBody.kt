package com.movie_master.moviemaster.data.shared_data

import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class RequestBody {
    private val mediaType = "application/json".toMediaTypeOrNull()
    val createSessionRequestBody = RequestBody.create(mediaType, "{\"request_token\":\"${profileScreenStates.requestToken.request_token}\"}")
    val deleteSessionRequestBody = RequestBody.create(mediaType, "{\"session_id\":\"${profileScreenStates.sessionId.session_id}\"}")
    fun listItemStatusRequestBody(listType: String, result: String): RequestBody {
        return RequestBody.create(mediaType,
            "{\"media_type\":\"${manageProfileOperations.getMediaType(sharedStates.selectedMediaItem)}\",\"media_id\":${manageProfileOperations.getMediaId(sharedStates.selectedMediaItem)},\"$listType\":$result}" )
    }
}