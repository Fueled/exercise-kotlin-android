# Fueled Kotlin Exercise

A blogging platform stores the following information that is available through separate API endpoints:
+ user accounts
+ blog posts for each user
+ comments for each blog post

### Objective
The organization needs to identify the 3 most engaging bloggers on the platform. Using only Kotlin and the Kotlin standard library, output the top 3 users with the highest average number of comments per post in the following format:

&nbsp;&nbsp;&nbsp; `[name]` - `[id]`, Score: `[average_comments]`

Instead of connecting to a remote API, we are providing this data in the form of JSON files, which have been made accessible through a custom Data object that provides the parsed JSON data to the data model you provide using Gson. For e.g. parsing the users data:

&nbsp;&nbsp;&nbsp; ```val users: List<T> = Data.getUsers()```

Where `<T>` would be the type of your user model.


### What we're looking to evaluate
1. How you choose to model your data
2. How you transform the provided JSON data to your data model
3. How you use your models to calculate this average value
4. How you use this data point to sort the users

### Instructions
1. Fork our repo to your own Github account and **make private**
2. Invite user `fueledbot` to collaborate on that repo
3. Address each step of the problem above and commit as necessary
4. Once you are finished, open a PR on your work and assign `fueledbot` as the reviewer
