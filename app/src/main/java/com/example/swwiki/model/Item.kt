package com.example.swwiki.model

import java.io.Serializable

data class Item(
     val name: String,
     val url: String,
): Serializable{
     fun getItemId(url: String): String {
          var result: List<String> = url.split("/")
          var id: String = result[result.size-2]
          return id
     }
}
