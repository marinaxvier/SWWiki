package com.example.swwiki.model

import com.google.gson.annotations.SerializedName
import javax.security.auth.login.LoginException

data class PeopleResponse(
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: List<PeopleData>
    )


