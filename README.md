# DeviceCare
An android client for vadimeladii/Remember project. It's about taking care of your electronic devices, by reminding you some useful tips.

If you want to run the project and can't connect to the server, it means that the server is down.
For this case, I created a mock API:
1) Install node.js
2) Launch the terminal in the folder mockAPI. Run "npm install". Then, run "npm start bin/www".
3) Now you have something similar to a server. In the Android file RetrofitController.java, modify the constant "BASE_URL" to your IP and port 3000.
4) You can login now with the email "abc@gmail.com" and the password "def".
