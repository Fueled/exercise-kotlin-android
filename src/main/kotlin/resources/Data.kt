package resources


object Data {

    /**
     * Returns the content of `posts.json` parsed to the type [T] using Gson.
     */
    inline fun <reified T> getPosts(): T = Parser.getMappedData("posts.json")

    /**
     * Returns the content of `comments.json` parsed to the type [T] using Gson.
     */
    inline fun <reified T> getComments(): T = Parser.getMappedData("comments.json")

    /**
     * Returns the content of `users.json` parsed to the type [T] using Gson.
     */
    inline fun <reified T> getUsers(): T = Parser.getMappedData("users.json")

}