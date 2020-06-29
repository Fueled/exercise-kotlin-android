import model.comment.Comment
import model.post.Post
import model.userscore.UserScore
import resources.Data

/**

# Fueled Kotlin Exercise

A blogging platform stores the following information that is available through separate API endpoints:
+ model.user accounts
+ blog model.posts for each model.user
+ model.comments for each blog post

### Objective
The organization needs to identify the 3 most engaging bloggers on the platform. Using only Kotlin and the Kotlin standard library, output the top 3 users with the highest average number of model.comments per post in the following format:

`[name]` - `[id]`, Score: `[average_comments]`

Instead of connecting to a remote API, we are providing this data in form of JSON files, which have been made accessible through a custom Resource enum with a `data` method that provides the contents of the file.

### What we're looking to evaluate
1. How you choose to model your data
2. How you transform the provided JSON data to your data model
3. How you use your models to calculate this average value
4. How you use this data point to sort the users

 */

// 1. First, start by modeling the data objects that will be used.


fun main(vararg args: String) {

    // 2. Next, decode the JSON source using `[Data.getUsers()]`

    // Getting users using Data.kt
    val users = getUsers()

    // Getting posts using Data.kt
    val posts = getPosts()

    // Getting comments using Data.kt
    val comments = getComments()

    // 3. Finally, calculate the average number of model.comments per model.user and use it
    //    to find the 3 most engaging bloggers and output the result.

    // calculating top 3 users
    getTopThreeUsers(users, posts, comments)

}

private fun getUsers(): List<User> {
    val users = Data.getUsers<List<User>>()
    return users
}

private fun getPosts(): List<Post> {
    val posts = Data.getPosts<List<Post>>()
    return posts
}

private fun getComments(): List<Comment> {
    val comments = Data.getComments<List<Comment>>()
    return comments
}

 //function to calculate top three users
private fun getTopThreeUsers(users: List<User>, posts: List<Post>, comments: List<Comment>) {
    // list for holding the model with name, id and score
    val users_score = mutableListOf<UserScore>()

    for (user in users) {
        // get total comments per user
        val total_comment_count = countTotalCommentsPerUser(user, posts, comments)

        // get total posts per user
        val total_posts_per_user = countPostsPerUser(user, posts)

        // calculate the ratio of total comments to total posts
        val avg = total_comment_count/total_posts_per_user

        // adding the model UserScore to the list
        users_score.add(UserScore(user.id, user.name, avg))

    }

     // sorting the list in descending order of score
     users_score.sortByDescending { it.score  }
    println("TOP 3 USERS ARE : ")
    // printing top three users from the users_score list
    println("${users_score.take(3)}")
}

// function to find out how total comments each user has
private fun countTotalCommentsPerUser(user: User, posts: List<Post>, comments: List<Comment>): Double {
    var commentcount = 0
    for (post in posts) {
        if (user.id == post.userId) {
            // getting the comments per post per user and calculating the total comments per user
            commentcount += countCommentsPerPostPerUser(user.id, post, comments)
        }
    }
    return commentcount.toDouble()
}

// function to find out comments per post per user
private fun countCommentsPerPostPerUser(userId: Int, post: Post, comments: List<Comment>): Int {
    var comment_count = 0
    for (comment in comments) {
        if (comment.postId == post.id && userId == post.userId) {
            comment_count++
        }
    }
    return comment_count
}

// function to find out total number of posts per user
private fun countPostsPerUser(user: User, posts: List<Post>): Double {
    var post_count = 0;
    for (post in posts) {
        if (user.id == post.userId) {
            post_count++
        }
    }
    return post_count.toDouble()
}