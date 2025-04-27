---------Commits and their respective changes----------
1. Implemented splash screen but it didn't seem to work as intended because the default screen appears in the first go then the splash launches but when in AMF.xml, I set the theme to default one, it worked.
2. Implemented retrofit, fonts, dagger and hilt for api calls, textfont and dependency injection.
3. Did the setup of signup screen with animation and other composables, set up its viewmodel. Next is to do the backend setup for signup.
4. In this commit, I have enabled the sign-up functionality and explored various computer networking concepts as applied in this project. Key challenges and learnings at this stage include the need to pass the IP address in the base URL and verify the IP from the phone to establish a successful connection. This step is essential for enabling communication between the client (Android app) and the server (Ktor backend), reflecting how client-server architecture operates in real-world scenarios.
5. Here the things were simple, just setup navigations across screens and implemented the signin feature via backend. Next we will change the fade in fade out animation while navigating to another screen from one.
6. Here, the signin is successfully tested, the google signin implementation is successful too as well as the fade animation is changed to left to right or similar transition, good thing is fade animation is changed easily.
7. I fixed authentication edge cases like what happens on user doesn't behave as intended, sheet will appear popping signin failed msg. Setup token based sessions, Started homescreen implementation.
8. Implemented restaurant list their menu and shared animations.
