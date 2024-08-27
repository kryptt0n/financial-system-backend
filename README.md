OpenAPI definition body { font-family: Trebuchet MS, sans-serif; font-size: 15px; color: #444; margin-right: 24px; } h1 { font-size: 25px; } h2 { font-size: 20px; } h3 { font-size: 16px; font-weight: bold; } hr { height: 1px; border: 0; color: #ddd; background-color: #ddd; } .app-desc { clear: both; margin-left: 20px; } .param-name { width: 100%; } .license-info { margin-left: 20px; } .license-url { margin-left: 20px; } .model { margin: 0 0 0px 20px; } .method { margin-left: 20px; } .method-notes { margin: 10px 0 20px 0; font-size: 90%; color: #555; } pre { padding: 10px; margin-bottom: 2px; } .http-method { text-transform: uppercase; } pre.get { background-color: #0f6ab4; } pre.post { background-color: #10a54a; } pre.put { background-color: #c5862b; } pre.delete { background-color: #a41e22; } .huge { color: #fff; } pre.example { background-color: #f3f3f3; padding: 10px; border: 1px solid #ddd; } code { white-space: pre; } .nickname { font-weight: bold; } .method-path { font-size: 1.5em; background-color: #0f6ab4; } .up { float:right; } .parameter { width: 500px; } .param { width: 500px; padding: 10px 0 0 20px; font-weight: bold; } .param-desc { width: 700px; padding: 0 0 0 20px; color: #777; } .param-type { font-style: italic; } .param-enum-header { width: 700px; padding: 0 0 0 60px; color: #777; font-weight: bold; } .param-enum { width: 700px; padding: 0 0 0 80px; color: #777; font-style: italic; } .field-label { padding: 0; margin: 0; clear: both; } .field-items { padding: 0 0 15px 0; margin-bottom: 15px; } .return-type { clear: both; padding-bottom: 10px; } .param-header { font-weight: bold; } .method-tags { text-align: right; } .method-tag { background: none repeat scroll 0% 0% #24A600; border-radius: 3px; padding: 2px 10px; margin: 2px; color: #FFF; display: inline-block; text-decoration: none; }

OpenAPI definition
==================

No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)

More information: [https://helloreverb.com](https://helloreverb.com)

Contact Info: [hello@helloreverb.com](hello@helloreverb.com)

Version: v1

All rights reserved

http://apache.org/licenses/LICENSE-2.0.html

Access
------

Methods
-------

\[ Jump to [Models](#__Models) \]

### Table of Contents

#### [LabelController](#LabelController)

*   [`post /labels`](#createLabel)
*   [`delete /labels/{id}`](#deleteLabel)
*   [`get /labels/{id}`](#getLabel)
*   [`get /labels`](#getLabels)
*   [`put /labels`](#updateLabel)

#### [TransactionController](#TransactionController)

*   [`post /transactions`](#createTransaction)
*   [`delete /transactions/{id}`](#deleteTransaction)
*   [`get /transactions/pdf`](#getPdfFile)
*   [`get /transactions`](#getTransactions)
*   [`post /transactions/parse`](#parseTransactions)
*   [`put /transactions`](#updateTransaction)

#### [TransactionGroupController](#TransactionGroupController)

*   [`post /transaction-groups`](#createTransactionGroup)
*   [`delete /transaction-groups/{id}`](#deleteTransactionGroup)
*   [`get /transaction-groups`](#getAllTransactionGroups)
*   [`put /transaction-groups`](#updateTransactionGroup)

#### [UserController](#UserController)

*   [`delete /users`](#deleteUser)
*   [`post /forgot-password`](#forgotPassword)
*   [`get /users`](#getUsers)
*   [`post /register`](#registerUser)
*   [`post /reset-password`](#resetPassword)
*   [`post /verify`](#verifyUser)

LabelController
===============

[Up](#__Methods)

    post /labels

(createLabel)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [Label](#Label) (required)

Body Parameter —

### Return type

[Label](#Label)

### Example data

Content-Type: application/json

    {
      "name" : "name",
      "id" : 5
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [Label](#Label)

* * *

[Up](#__Methods)

    delete /labels/{id}

(deleteLabel)

### Path parameters

id (required)

Path Parameter — format: int32

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    get /labels/{id}

(getLabel)

### Path parameters

id (required)

Path Parameter — format: int32

### Return type

[Label](#Label)

### Example data

Content-Type: application/json

    {
      "name" : "name",
      "id" : 5
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [Label](#Label)

* * *

[Up](#__Methods)

    get /labels

(getLabels)

### Return type

array\[[Label](#Label)\]

### Example data

Content-Type: application/json

    [ {
      "name" : "name",
      "id" : 5
    }, {
      "name" : "name",
      "id" : 5
    } ]

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK

* * *

[Up](#__Methods)

    put /labels

(updateLabel)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [Label](#Label) (required)

Body Parameter —

### Return type

[Label](#Label)

### Example data

Content-Type: application/json

    {
      "name" : "name",
      "id" : 5
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [Label](#Label)

* * *

TransactionController
=====================

[Up](#__Methods)

    post /transactions

(createTransaction)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [Transaction](#Transaction) (required)

Body Parameter —

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    delete /transactions/{id}

(deleteTransaction)

### Path parameters

id (required)

Path Parameter — format: int32

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    get /transactions/pdf

(getPdfFile)

### Query parameters

from (optional)

Query Parameter — format: date-time

to (optional)

Query Parameter — format: date-time

label (optional)

Query Parameter —

type (optional)

Query Parameter — format: int32

group (optional)

Query Parameter —

### Return type

array\[byte\[\]\]

### Example data

Content-Type: application/json

    [ "", "" ]

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK

* * *

[Up](#__Methods)

    get /transactions

(getTransactions)

### Query parameters

from (optional)

Query Parameter — format: date-time

to (optional)

Query Parameter — format: date-time

label (optional)

Query Parameter —

type (optional)

Query Parameter — format: int32

group (optional)

Query Parameter —

all (optional)

Query Parameter —

pageable (required)

Query Parameter —

### Return type

[CustomPageTransactionResponse](#CustomPageTransactionResponse)

### Example data

Content-Type: application/json

    {
      "pageNumber" : 7,
      "totalPages" : 2,
      "pageSize" : 9,
      "content" : [ {
        "amount" : 1.4658129805029452,
        "balance" : 5.962133916683182,
        "transactionGroup" : {
          "name" : "name",
          "id" : 2
        },
        "hashcode" : "hashcode",
        "description" : "description",
        "id" : 0,
        "label" : {
          "name" : "name",
          "id" : 6
        },
        "transactionDate" : "2000-01-23T04:56:07.000+00:00",
        "type" : {
          "name" : "name",
          "id" : 5
        },
        "user" : {
          "email" : "email"
        }
      }, {
        "amount" : 1.4658129805029452,
        "balance" : 5.962133916683182,
        "transactionGroup" : {
          "name" : "name",
          "id" : 2
        },
        "hashcode" : "hashcode",
        "description" : "description",
        "id" : 0,
        "label" : {
          "name" : "name",
          "id" : 6
        },
        "transactionDate" : "2000-01-23T04:56:07.000+00:00",
        "type" : {
          "name" : "name",
          "id" : 5
        },
        "user" : {
          "email" : "email"
        }
      } ],
      "totalElements" : 3
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [CustomPageTransactionResponse](#CustomPageTransactionResponse)

* * *

[Up](#__Methods)

    post /transactions/parse

(parseTransactions)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [transactions\_parse\_body](#transactions_parse_body) (optional)

Body Parameter —

### Return type

String

### Example data

Content-Type: application/json

    ""

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [String](#String)

* * *

[Up](#__Methods)

    put /transactions

(updateTransaction)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [Transaction](#Transaction) (required)

Body Parameter —

### Return type

[Transaction](#Transaction)

### Example data

Content-Type: application/json

    {
      "createdAt" : "2000-01-23T04:56:07.000+00:00",
      "amount" : 5.637376656633329,
      "balance" : 2.3021358869347655,
      "transactionGroup" : {
        "transactionType" : {
          "name" : "name",
          "id" : 5
        },
        "name" : "name",
        "id" : 1
      },
      "hashcode" : "hashcode",
      "description" : "description",
      "id" : 0,
      "label" : {
        "name" : "name",
        "id" : 5
      },
      "transactionDate" : "2000-01-23T04:56:07.000+00:00",
      "user" : {
        "password" : "password",
        "gender" : "gender",
        "dob" : "2000-01-23T04:56:07.000+00:00",
        "active" : true,
        "id" : 6,
        "email" : "email",
        "username" : "username"
      }
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [Transaction](#Transaction)

* * *

TransactionGroupController
==========================

[Up](#__Methods)

    post /transaction-groups

(createTransactionGroup)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [TransactionGroup](#TransactionGroup) (required)

Body Parameter —

### Return type

[TransactionGroup](#TransactionGroup)

### Example data

Content-Type: application/json

    {
      "transactionType" : {
        "name" : "name",
        "id" : 5
      },
      "name" : "name",
      "id" : 1
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [TransactionGroup](#TransactionGroup)

* * *

[Up](#__Methods)

    delete /transaction-groups/{id}

(deleteTransactionGroup)

### Path parameters

id (required)

Path Parameter — format: int32

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    get /transaction-groups

(getAllTransactionGroups)

### Return type

array\[[TransactionGroupResponse](#TransactionGroupResponse)\]

### Example data

Content-Type: application/json

    [ {
      "name" : "name",
      "id" : 2
    }, {
      "name" : "name",
      "id" : 2
    } ]

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK

* * *

[Up](#__Methods)

    put /transaction-groups

(updateTransactionGroup)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [TransactionGroup](#TransactionGroup) (required)

Body Parameter —

### Return type

[TransactionGroup](#TransactionGroup)

### Example data

Content-Type: application/json

    {
      "transactionType" : {
        "name" : "name",
        "id" : 5
      },
      "name" : "name",
      "id" : 1
    }

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [TransactionGroup](#TransactionGroup)

* * *

UserController
==============

[Up](#__Methods)

    delete /users

(deleteUser)

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    post /forgot-password

(forgotPassword)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [ForgotPassword](#ForgotPassword) (required)

Body Parameter —

### Return type

String

### Example data

Content-Type: application/json

    ""

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [String](#String)

* * *

[Up](#__Methods)

    get /users

(getUsers)

### Return type

array\[[User](#User)\]

### Example data

Content-Type: application/json

    [ {
      "password" : "password",
      "gender" : "gender",
      "dob" : "2000-01-23T04:56:07.000+00:00",
      "active" : true,
      "id" : 6,
      "email" : "email",
      "username" : "username"
    }, {
      "password" : "password",
      "gender" : "gender",
      "dob" : "2000-01-23T04:56:07.000+00:00",
      "active" : true,
      "id" : 6,
      "email" : "email",
      "username" : "username"
    } ]

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK

* * *

[Up](#__Methods)

    post /register

(registerUser)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [UserRequest](#UserRequest) (required)

Body Parameter —

### Responses

#### 200

OK[](#)

* * *

[Up](#__Methods)

    post /reset-password

(resetPassword)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [ResetPassword](#ResetPassword) (required)

Body Parameter —

### Query parameters

token (required)

Query Parameter —

### Return type

String

### Example data

Content-Type: application/json

    ""

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [String](#String)

* * *

[Up](#__Methods)

    post /verify

(verifyUser)

### Consumes

This API call consumes the following media types via the Content-Type request header:

*   `application/json`

### Request body

body [UserVerification](#UserVerification) (required)

Body Parameter —

### Return type

String

### Example data

Content-Type: application/json

    ""

### Produces

This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.

*   `*/*`

### Responses

#### 200

OK [String](#String)

* * *

Models
------

\[ Jump to [Methods](#__Methods) \]

### Table of Contents

1.  [`CustomPageTransactionResponse`](#CustomPageTransactionResponse)
2.  [`ForgotPassword`](#ForgotPassword)
3.  [`Label`](#Label)
4.  [`LabelResponse`](#LabelResponse)
5.  [`Pageable`](#Pageable)
6.  [`ResetPassword`](#ResetPassword)
7.  [`Transaction`](#Transaction)
8.  [`TransactionGroup`](#TransactionGroup)
9.  [`TransactionGroupResponse`](#TransactionGroupResponse)
10.  [`TransactionResponse`](#TransactionResponse)
11.  [`TransactionType`](#TransactionType)
12.  [`User`](#User)
13.  [`UserRequest`](#UserRequest)
14.  [`UserSimple`](#UserSimple)
15.  [`UserVerification`](#UserVerification)
16.  [`transactions_parse_body`](#transactions_parse_body)

### `CustomPageTransactionResponse` [Up](#__Models)

content (optional)

[array\[TransactionResponse\]](#TransactionResponse)

pageNumber (optional)

[Integer](#integer) format: int32

pageSize (optional)

[Integer](#integer) format: int32

totalElements (optional)

[Long](#long) format: int64

totalPages (optional)

[Integer](#integer) format: int32

### `ForgotPassword` [Up](#__Models)

email (optional)

[String](#string)

### `Label` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

name (optional)

[String](#string)

user (optional)

[User](#User)

### `LabelResponse` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

name (optional)

[String](#string)

user (optional)

[UserSimple](#UserSimple)

### `Pageable` [Up](#__Models)

page (optional)

[Integer](#integer) format: int32

size (optional)

[Integer](#integer) format: int32

sort (optional)

[array\[String\]](#string)

### `ResetPassword` [Up](#__Models)

password (optional)

[String](#string)

### `Transaction` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

user (optional)

[User](#User)

hashcode (optional)

[String](#string)

transactionGroup (optional)

[TransactionGroup](#TransactionGroup)

label (optional)

[Label](#Label)

createdAt (optional)

[Date](#DateTime) format: date-time

transactionDate (optional)

[Date](#DateTime) format: date-time

amount (optional)

[Double](#double) format: double

description (optional)

[String](#string)

balance (optional)

[Double](#double) format: double

type (optional)

[TransactionType](#TransactionType)

### `TransactionGroup` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

name (optional)

[String](#string)

transactionType (optional)

[TransactionType](#TransactionType)

user (optional)

[User](#User)

### `TransactionGroupResponse` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

name (optional)

[String](#string)

transactionType (optional)

[TransactionType](#TransactionType)

user (optional)

[UserSimple](#UserSimple)

### `TransactionResponse` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

user (optional)

[UserSimple](#UserSimple)

hashcode (optional)

[String](#string)

label (optional)

[LabelResponse](#LabelResponse)

transactionDate (optional)

[Date](#DateTime) format: date-time

amount (optional)

[Double](#double) format: double

description (optional)

[String](#string)

balance (optional)

[Double](#double) format: double

type (optional)

[TransactionType](#TransactionType)

transactionGroup (optional)

[TransactionGroupResponse](#TransactionGroupResponse)

### `TransactionType` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

name (optional)

[String](#string)

### `User` [Up](#__Models)

id (optional)

[Integer](#integer) format: int32

username (optional)

[String](#string)

password (optional)

[String](#string)

dob (optional)

[Date](#DateTime) format: date-time

email (optional)

[String](#string)

gender (optional)

[String](#string)

active (optional)

[Boolean](#boolean)

### `UserRequest` [Up](#__Models)

email (optional)

[String](#string)

username (optional)

[String](#string)

password (optional)

[String](#string)

gender (optional)

[String](#string)

dob (optional)

[Date](#DateTime) format: date-time

### `UserSimple` [Up](#__Models)

email (optional)

[String](#string)

### `UserVerification` [Up](#__Models)

email (optional)

[String](#string)

token (optional)

[String](#string)

### `transactions_parse_body` [Up](#__Models)

file

[byte\[\]](#binary) format: binary
