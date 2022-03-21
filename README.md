# SimpleTodo
This project is a bare bones, example project for making your own Android app and Scala backend. I used this project to learn how to create and deploy a backend service (I was already familiar with Android development).

I wanted to make this project public because I imagine there are some Android developers out there who are interested in learning more about backend. If that's you, then this repo (and the [backend repo](https://github.com/MackHartley/SimpleTodoService)) would be a good reference to learn how to make your own backend scala service.

<a href='https://play.google.com/store/apps/details?id=com.mackhartley.simpletodo&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' width="300" src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png'/></a>

# Technical Details

Below is a summary of the tech stack used for this project:
| System            | Technologies Used |
| ----------------- | ----------------- |
| Andoid App        | Kotlin, Coroutines, Koin, Retrofit, MVVM, Single Activity Multi Fragment|
| Authentication    | Auth0 SDK (Android & Scala), OAuth2.0, JWT|
| Backend Service   | Scala, Play Framework, Slick|
| Database          | Postgres, PSQL|

If you are interested in using Scala Play to make your own backend service, below are a few good resources to review. These are the same resources I used to teach myself:
- [The free chapters of Hands On Scala (Sufficient for getting comfortable with Scala)](https://www.handsonscala.com/table-of-contents.html)
- [Scala Play Framework Tutorials by Mark Lewis](https://www.youtube.com/watch?v=FqMDHsFNlxQ&list=PLLMXbkbDbVt8tBiGc1y69BZdG8at1D7ZF)
- [Official Play Documentation](https://www.playframework.com/documentation/2.8.x/Home)

The approach I took for making this project was the following:
1) Build the backend service. I used the above resources to learn how to do this
2) Create the Android app
3) Get the Android app and backend service to communicate with each other
4) Start adding authentication to the backend service and app via Auth0. [This is a good Scala + Auth0](https://auth0.com/blog/build-and-secure-a-scala-play-framework-api/) tutorial
5) Add Auth0 to the Android app. [This is a good Android + Auth0](https://auth0.com/docs/quickstart/native/android/00-login) doc
6) Ensure that the app and backend service can still communicate now that authentication has been added
7) Deploy the backend service to [Heroku](https://www.heroku.com/home)

# Pictures
<img src="https://user-images.githubusercontent.com/10659285/124343743-cb6bc080-db82-11eb-94c6-74b9690072c9.png" width="200dp" />   <img src="https://user-images.githubusercontent.com/10659285/124343763-edfdd980-db82-11eb-9c7a-9d772b8b6daf.png" width="200dp" />   <img src="https://user-images.githubusercontent.com/10659285/124343765-f0603380-db82-11eb-979e-e26044c17ea4.png" width="200dp" />
