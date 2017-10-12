
@mariebot1
Feature: Marie ChatBot Test Feature

    Scenario Outline: Test FaceBook Conversation
      Given FaceBook user is "<fb_user>"
      When "<fb_user>" says in chat "<user_says>"
      Then Marie says to "<fb_user>" "<marie_says>"

    @getstarted
      Examples: Get started
        |fb_user|user_says|marie_says|
        |fb_user_2 |[Get started] |Dag {user_name}! Heb je een vraag over ING-bankkaarten? Dan kan onze digitale assistente, Marie, je helpen in het Engels. Het ING Webcare-team is nog steeds beschikbaar om je te helpen in het Nederlands. Wil je met Marie over ING-bankkaarten praten?  |
        |fb_user_2 |[Ja] |Excellent! My name is Marie, pleased to meet you! I can activate your card abroad, block it, check the delivery status, order a new one, reset your pin code etc. Just ask me  |

    @activatecard
      Examples: Activate card
        |fb_user|user_says|marie_says|
        |fb_user_2 |I want to activate my card  |Ok Theodore, I understood that you want to activate your card, but I will need a bit more information to help you correctly. Do you need to activate your card abroad, do you want to activate your newly received card or is your current card inactive?  |
        |fb_user_2 |[New Card]  |Is it your first ING card you want to activate or a replacement of an existing card? Or maybe you blocked your card using Card Stop?  |
        |fb_user_2 |[First card]  |Do you already know your pin code or do you want me to assist you in retrieving it?  |
        |fb_user_2 |[I know it]  |You need to activate your card by using it in a cash dispenser, in a shop or on the internet and entering your pin code. Do you have other questions?  |

    @carddeliveryauthentication
      Examples: Card delivery - Authentication
        |fb_user|user_says|marie_says|
        |fb_user_2 |When will my card be delivered? |I understand that you are expecting a card from us. This can take up to ten days. If you like, I can check the delivery status of your card, but for this I will need to authenticate you. Do you want to proceed?  |
        |fb_user_2 |[Yes]  |In order to continue, I'll need to verify your identity. Could you tell me your birthdate, please?  |
        |fb_user_2 |DD/MM/YYYY  |Thanks! If I can find your Facebook name and birthday in our systems, I will send an SMS token to your mobile within a minute. Please enter this token in messenger in order to ensure the safety of our chat.  |
        |fb_user_2 |TOKEN  |Awesome, token correct! I'll trust you for the next 10 minutes. One sec. |
        |fb_user_2 | |Please pick the card you are waiting for: |
        |fb_user_2 |[This one!] |You ordered this card on 09/08/2017, and we have sent it to you on 11/08/2017 to the following address:* * * 601330 Rixensart Is this the correct address? |
        |fb_user_2 |[Yes] |Would you like to wait a little longer or do you want us to send your card to your branch instead? |
        |fb_user_2 |[Wait] |Ok, feel free to ask me again in a few days if your card still hasn't arrived. Can I meanwhile help you with anything else? |

    @cardstop
      Examples: Card stop
        |fb_user|user_says|marie_says|
        |fb_user_2 |Block my card |I recommend you to block your card by contacting Card Stop at +32 70 344 344. A new card will be automatically created and sent to your contact address. Has your card been misused? |
        |fb_user_2 |[Yes] |Is it a debit or credit card? |
        |fb_user_2 |[Credit card]  |After having blocked your card via Card Stop, please go to the nearest police station for an official police report. In order to contest the transactions, you need to fill in the form on www.mijnkaart.be. If you have questions about the form or the transactions themselves, please contact Atos Worldline at +32 2 205 85 85. Is there anything else I can do for you? |

    @showcards
      Examples: Show cards
        |fb_user|user_says|marie_says|
        |fb_user_2 |Show my cards |[Authenticate] |
        |fb_user_2 | |Here are all your cards, Thomas: |
        |fb_user_2 | |[List of cards] |
        |fb_user_2 |[This one!] |I see. And what would you like to do with this card? |

    @contactlessordercard
      Examples: Contactless / Order card
        |fb_user|user_says|marie_says|
        |fb_user_2 |I�d like to have the wireless function |You can easily check if your card has the contactless feature. Just look for the contactless symbol on your card. It looks like the image below. If you don't see it, I can help you replace your old card with a new one with this feature. Shall I? Please keep in mind that I would have to authenticate you for this. |
        |fb_user_2 | |[Picture wireless] |
        |fb_user_2 |[Yes] |In order to help you further, I first need to know if you're an ING client or not. Select **I am a customer** if you want to order a card coupled to an existing account. Select **I'm not a customer** if you are not an ING customer yet, and you are feeling left out. I will then guide you through the process of ordering a card and becoming a glorious ING client  |
        |fb_user_2 |[I am a customer] |Great! Do you want to order an extra card or replace an existing one? |
        |fb_user_2 |AUTH | |
        |fb_user_2 |[Replace card] |Ok perfect, let's have a look. I still need a few more details from you. Can you tell me why you need to replace your card? Is your card expiring? Is it worn out or do you wish to have a new one with contactless feature? |
        |fb_user_2 |[Contactless] |I can help you order new card with contactless feature. Just tell me which old card I can replace with this new one: |
        |fb_user_2 |[This one!] |Is it ok if we send your new card to D***, * 60, 1330 Rixensart? |
        |fb_user_2 |[Yes] |Ok, I will create a request to send a card to D***, * 60, 1330 Rixensart . Can you confirm everything is correct? |
        |fb_user_2 |[Yes] |Great! We will send a new card to your address! It should arrive in a few days. |
        |fb_user_2 | |MAIL |

    @infocharges
      Examples: Info charges
        |fb_user|user_says|marie_says|
        |fb_user_2 |Which card should I use in the United States? |Let's have a look into the card charges, then. Is it a debit or a credit card? |
        |fb_user_2 |[Debit] |In which country will you use your debit card? |
        |fb_user_2 |China |Please check the paragraph related to cards in our charges and regulations brochure https://www.ing.be/static/legacy/SiteCollectionDocuments/TarievenNatuurlijkePersonenNewEN.pdf. Please keep in mind that in order to use your debit card outside of the eurozone, you will need to activate it. Would you like me to do this for you? |
        |fb_user_2 |[No] |Ok, no problem! Can I help you with anything else? |

    @newpin
      Examples: New pin
        |fb_user|user_says|marie_says|
        |fb_user_2 |Where�can�I�find�my pin�code |I understand you would like to have a new pin code for your card. Can you tell me the reason?  Do you want to modify your existing pin code? Did you block your card? Or do you need to obtain your pin code via SMS for a newly received card? |
        |fb_user_2 |[Modify PIN] |I will do my best to help you. Do you still remember your pin code? |
        |fb_user_2 |[Yes] |It's easy, you just need to go to an ATM and choose the option **change pin**. Can I help you with something else? |

    @newpinsms
      Examples: New pin SMS
        |fb_user|user_says|marie_says|
        |fb_user_2 |I�want�to�get�my�PIN by�SMS |I understand that you are talking about the pin of your card, let me help you. Have you already tried to get it via SMS, do you need more information, or do you not wish to receive your code via SMS? |
        |fb_user_2 |Modify PIN |I will do my best to help you. Do you still remember your pin code? |
        |fb_user_2 |Yes |It's easy, you just need to go to an ATM and choose the option **change pin**. Can I help you with something else? |

    @welcomback
      Examples: Welcom back
        |fb_user|user_says|marie_says|
        |fb_user_2 |Hello |Welcome Back, Thomas! Do you have a question about ING bank cards and can I respond to you in English? If so, press **yes**. If not, press **no** and my Webcare-team colleagues will be more than happy to help you. |
        |fb_user_2 |[Yes] |Excellent! I can activate your card abroad, block it, check the delivery status, order a new one, reset your pin code etc. Just ask me  |
        |fb_user_2 |Hello |Welcome Back, Thomas! Do you have a question about ING bank cards and can I respond to you in English? If so, press **yes**. If not, press **no** and my Webcare-team colleagues will be more than happy to help you. |
        |fb_user_2 |[No] |My human colleagues of the Webcare-team can help you. They are available from Monday till Friday between 8h00 and 22h00 and on Saturday from 9h00h till 17h00. |
        |fb_user_2 |test |/ |

    @inactivitynps
      Examples: Inactivity / NPS
        |fb_user|user_says|marie_says|
        |fb_user_2 | |I haven't heard from you in a while, Thomas. Just get back to me when convenient  Meanwhile, would you mind providing me some feedback? To what degree are you satisfied with the conversation we just had? |
