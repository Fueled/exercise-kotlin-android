package model.userscore


// Model class created for holding id, name and score of each user


data class UserScore(
        val id : Int,
        val name : String,
        val score : Double
) {
    override fun toString(): String = "$name - $id, Score: $score"
}