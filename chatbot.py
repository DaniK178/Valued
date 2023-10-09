from dotenv import dotenv_values
from hugchat import hugchat
from hugchat.login import Login

'''
HUGGINGCHAT BOT TO GIVE RESPONSE TO USER INPUT
'''

class ChatBot:
    def __init__(self):
        self._get_and_store_hf_credentials()
        
    def _get_and_store_hf_credentials(self):
        self.secrets = dotenv_values("secrets.env")
        self.hf_email = self.secrets["EMAIL"]
        self.hf_password = self.secrets["PASSWORD"]

    def _sign_in_and_create_chatbot(self):
        sign_in = Login(self.hf_email, self.hf_password)
        cookies = sign_in.login()
        self.chatbot = hugchat.ChatBot(cookies = cookies.get_dict())
        return self.chatbot

    def generate_response(self, user_input: str) -> str:
        if not hasattr(self, "chatbot"):
            self._sign_in_and_create_chatbot()
        context = """
        Respond to the following question as a workplace ally and mentor for an employee. The employee who you are advising is based in the UK, so please refer to policies of the United Kingdom, if any, in your answer.

        Question: 
        """
        response = self.chatbot.chat(context + user_input)
        print(response)
        return response

if __name__ == "__main__":
    bot = ChatBot()
    bot.generate_response("Can workplace adjustments apply to mental health?")