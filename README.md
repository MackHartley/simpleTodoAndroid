# SimpleTodo
The SimpleTodo app is a todo app for Android. It is simple, free and open source. 

*Note, as the app is on a free Heroku tier it is quite slow on the initial call as it has to wake up the service. Due to this, the app is more of a demonstration of how to build a full stack app, rather than being an actual todo list competitor.*

<a href='https://play.google.com/store/apps/details?id=com.mackhartley.simpletodo&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' width="300" src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png'/></a>

# Technical Details

I decided to make this app because I wanted to practice creating REST APIs with the [Play Framework](https://www.playframework.com/). Additionally, I wanted to get more familiar with OAuth2.0 authentication so I decided to implement the [Authorization Code Flow Grant with PKCE](https://auth0.com/docs/flows/authorization-code-flow-with-proof-key-for-code-exchange-pkce). 

I also wanted to make this project because I imagine there are some other Android developers out there who are interested in learning more about backend. If that's you, then this repo (and the [backend repo](https://github.com/MackHartley/SimpleTodoService)) would be a good reference to learn how to make your own backend service.

Below is a summary of the tech stack used for this project:
| System            | Technologies Used |
| ----------------- | ----------------- |
| Andoid App        | Kotlin, Coroutines, Koin, Retrofit, MVVM, Single Activity Multi Fragment|
| Authentication    | Auth0 SDK (Android & Scala), OAuth2.0, JWT|
| Backend Service   | Scala, Play Framework, Slick|
| Database          | Postgres, PSQL|

If you would like to learn how to make your own REST APIs, I recommend learning the Scala language and the Play Framework (for Scala). Scala and Scala Play are used widely at large tech companies (like LinkedIn) and are easy to work with. Below are some of the resources I used to learn:
- [The free chapters of Hands On Scala (Sufficient for getting comfortable with Scala)](https://www.handsonscala.com/table-of-contents.html)
- [Scala Play Framework Tutorials by Mark Lewis](https://www.youtube.com/watch?v=FqMDHsFNlxQ&list=PLLMXbkbDbVt8tBiGc1y69BZdG8at1D7ZF)
- [Official Play Documentation](https://www.playframework.com/documentation/2.8.x/Home)

# Pictures
<img src="https://user-images.githubusercontent.com/10659285/124343743-cb6bc080-db82-11eb-94c6-74b9690072c9.png" width="200dp" />   <img src="https://user-images.githubusercontent.com/10659285/124343763-edfdd980-db82-11eb-9c7a-9d772b8b6daf.png" width="200dp" />   <img src="https://user-images.githubusercontent.com/10659285/124343765-f0603380-db82-11eb-979e-e26044c17ea4.png" width="200dp" />
