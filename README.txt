====================================================
How to start project with token based security
===================================================
1.Register user
=============== /messageconsumption/api/v1/public/register ==========

  like with this sample json
  {
  	"password":"test123",
  	"email":sample@gmail.com",
  	"firstName":"test",
  	"lastName":"sample"
  }

2. Generate token

============= /messageconsumption/api/v1/public/generate-token ==========

For token generation you can use same body of register api
{
  	"password":"test123",
  	"email":sample@gmail.com",
  	"firstName":"test",
  	"lastName":"sample"
  }

3. Get generated token and pass it to header in authorization parameter like

===========  Authorization = Bearer generatedToken ==========

Note: here Bearer is token initializer.

4. Now you can use message consumption api's with token.