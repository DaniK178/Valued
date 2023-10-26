# Valued
Repository to hold the code for the Valued BNTA Hack-for-Change team

Introducing our groundbreaking inclusivity portal, designed to revolutionize workplace accommodations. Inspired by a recent real-life incident, our third-party platform empowers employers to swiftly grant their employees access to crucial adjustments. Unlike the traditional process, which often takes weeks and involves a series of standard questions, our portal streamlines the procedure, ensuring employees promptly get the support they need.

At the heart of our Minimum Viable Product (MVP) is "Helen," a virtual AI Mentor enhancing user experience. Our platform is a significant step towards fostering a more inclusive work environment. Post MVP, we envision a world where our technology adapts to various cultures and languages, meeting diverse needs seamlessly.Had our hackathon journey been extended, we would have introduced versatile personas for ChatGPT, enabling it to resonate with individuals from all walks of life. Our ambitious vision involves tapping into the expertise of therapists, doctors, and life coaches to train the chatbot. This ensures reliability and robust recommendations and addresses ethical considerations surrounding AI.

"Valued" creates a more inclusive workplace where every individual's needs are understood, valued, and met with efficiency and compassion. Together, we're shaping a future where diversity thrives.

How To Run Our App
--------------------------------------
### Database:

The name of the database is: valued_history

This will run on  http://localhost:5342

### Backend: 

Get an API key from Openai: https://platform.openai.com/account/api-keys
If you created an OpenAI account within the last free months you will have access to free keys.

Copy that key and paste that into the resources main/src/application.properties, after:
  `openai.api.key:`.
Now run the Spring Boot application
This will run on  http://localhost:8080

### Frontend:

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

In the project directory, you can run these commands:
- `npm install`
- `npm install axios`
- `npm i react-chartjs-2 chart.js`
- `npm install @mui/material @emotion/react @emotion/styled`

To start up your react app, run this command:
`npm start`

This will run the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

--------------------------------------

### How to use our app.
1. On the navbar click on *Login* and sign in with your email and password.
2. Return to the *Navbar* and click on the *chatbot icon*.
3. Have a conversation with the bot Helen. Tell them about your work life, your struggles, and your successes, have fun!
4. Head to the navbar and select *Tips*.
5. There you should see three cards that will have tips: 1) Social recommendations. 2) Learning recommendations. 3) Disability Support recommendations.
6. Use these to help you in your workplace life!
