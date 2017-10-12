$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CBot_10-5-2017.feature");
formatter.feature({
  "line": 3,
  "name": "Marie ChatBot Test Feature",
  "description": "",
  "id": "marie-chatbot-test-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@mariebot1"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test FaceBook Conversation",
  "description": "",
  "id": "marie-chatbot-test-feature;test-facebook-conversation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "FaceBook user is \"\u003cfb_user\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "\"\u003cfb_user\u003e\" says in chat \"\u003cuser_says\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Marie says to \"\u003cfb_user\u003e\" \"\u003cmarie_says\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "Get started",
  "description": "",
  "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started",
  "rows": [
    {
      "cells": [
        "fb_user",
        "user_says",
        "marie_says"
      ],
      "line": 12,
      "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started;1"
    },
    {
      "cells": [
        "fb_user_1",
        "[Get started]",
        "Dag {user_name}! Heb je een vraag over ING-bankkaarten? Dan kan onze digitale assistente, Marie, je helpen in het Engels. Het ING Webcare-team is nog steeds beschikbaar om je te helpen in het Nederlands. Wil je met Marie over ING-bankkaarten praten?"
      ],
      "line": 13,
      "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started;2"
    },
    {
      "cells": [
        "fb_user_1",
        "[Ja]",
        "Excellent! My name is Marie, pleased to meet you! I can activate your card abroad, block it, check the delivery status, order a new one, reset your pin code etc. Just ask me"
      ],
      "line": 14,
      "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3366419,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Test FaceBook Conversation",
  "description": "",
  "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@mariebot1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "FaceBook user is \"fb_user_1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "\"fb_user_1\" says in chat \"[Get started]\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Marie says to \"fb_user_1\" \"Dag {user_name}! Heb je een vraag over ING-bankkaarten? Dan kan onze digitale assistente, Marie, je helpen in het Engels. Het ING Webcare-team is nog steeds beschikbaar om je te helpen in het Nederlands. Wil je met Marie over ING-bankkaarten praten?\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 18
    }
  ],
  "location": "StepDefs.facebook_user_is(String)"
});
formatter.result({
  "duration": 640541965,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 1
    },
    {
      "val": "[Get started]",
      "offset": 26
    }
  ],
  "location": "StepDefs.says_in_chat(String,String)"
});
formatter.result({
  "duration": 280237,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 15
    },
    {
      "val": "Dag {user_name}! Heb je een vraag over ING-bankkaarten? Dan kan onze digitale assistente, Marie, je helpen in het Engels. Het ING Webcare-team is nog steeds beschikbaar om je te helpen in het Nederlands. Wil je met Marie over ING-bankkaarten praten?",
      "offset": 27
    }
  ],
  "location": "StepDefs.marie_says_to(String,String)"
});
formatter.result({
  "duration": 13951182,
  "status": "passed"
});
formatter.after({
  "duration": 92371,
  "status": "passed"
});
formatter.before({
  "duration": 79877,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Test FaceBook Conversation",
  "description": "",
  "id": "marie-chatbot-test-feature;test-facebook-conversation;get-started;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@mariebot1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "FaceBook user is \"fb_user_1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "\"fb_user_1\" says in chat \"[Ja]\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Marie says to \"fb_user_1\" \"Excellent! My name is Marie, pleased to meet you! I can activate your card abroad, block it, check the delivery status, order a new one, reset your pin code etc. Just ask me\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 18
    }
  ],
  "location": "StepDefs.facebook_user_is(String)"
});
formatter.result({
  "duration": 64258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 1
    },
    {
      "val": "[Ja]",
      "offset": 26
    }
  ],
  "location": "StepDefs.says_in_chat(String,String)"
});
formatter.result({
  "duration": 3106708,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "fb_user_1",
      "offset": 15
    },
    {
      "val": "Excellent! My name is Marie, pleased to meet you! I can activate your card abroad, block it, check the delivery status, order a new one, reset your pin code etc. Just ask me",
      "offset": 27
    }
  ],
  "location": "StepDefs.marie_says_to(String,String)"
});
formatter.result({
  "duration": 458286,
  "status": "passed"
});
formatter.after({
  "duration": 66936,
  "status": "passed"
});
});