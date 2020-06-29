package model.comment

data class Comment(

        val postId : Int,
        val email : String,
        val name : String,
        val body : String,
        val id : Int
)