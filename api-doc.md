# AtColor API Doc
## ベースURL
`http://api-atcolor.cps.im.dendai.ac.jp`

このベースのURLの後にエンドポイントのパスを記述してAPIにアクセスする.
ex.) `GET http://api-atcolor.cps.im.dendai.ac.jp/v1/login`

## リクエスト一覧
- [[POST]  register](#register)
- [[POST]  login](#login)
- [[GET]   users](#users)
- [[GET]   pixels](#pixels)
- [[GET]   questions](#questions)
- [[GET]   users/:id](#users/:id)
- [[PUT]   users](#putUsers)
- [[PUT]   pixels](#putPixels)

### [POST]<a id="register">register</a>

ユーザを登録する

<使用例>

`POST http://api-atcolor.cps.im.dendai.ac.jp/v1/register `

```
{  　　
	"id": 1,   
	"username": "cpstaro",   
	"access_token": "1:1rr6ksguCF6zMXuiugSg" 　
}
```  

#### フィールド

|名前|概要|
|:--|:--|
|username|任意の名前|
|password|ログイン用のパスワード|

#### 成功
正しく登録ができれば, `access_token`が返ってきます.

### [POST]<a id="login">login</a>

作成したユーザ名とパスワードでログインする

<使用例>

`POST http://api-atcolor.cps.im.dendai.ac.jp/v1/login`
```
{  
	"id": 1,  
	"username": "cpstaro",  
	"access_token": "1:1rr6ksguCF6zMXuiugSg"  
}
```

#### フィールド

|名前|概要|
|:--|:--|
|username|任意の名前|
|password|ログイン用のパスワード|

### [GET] <a id="users">users</a>

全てのユーザ情報を取得する

<使用例>  

`GET http://api-atcolor.cps.im.dendai.ac.jp/v1/users`
```
{  
		"id": 1,  
		"username": "cpstaro",  
		"twitter": "cps_tdu",  
		"language": "python",  
		"total_point": 3,  
		"solved_questions": [  
			{  
				"id": 3,  
				"title": "can you PUT?",  
				"description": "自分のプロフィールを更新する。"  
			}  
		]    
	}  
  {  
		"id": 1,    
		"username": "cpsjiro",  
		"twitter": "cps_tdu2",  
		"language": "js",  
		"total_point": 2,  
		"solved_questions": [  
			{  
				"id": 2,  
				"title": "can you POST?",  
				"description": "ユーザを作成する"  
			}  
		]  
  }  
```

#### フィールド
なし

### [GET] <a id="pixels">pixels</a>

各座標の色情報の一覧を取得する.

<使用例>

`GET http://api-atcolor.cps.im.dendai.ac.jp/v1/pixels`
```
[	{  
		"id": 1,  
		"x": 0,  
		"y": 0,  
		"color": "#ffffff"  
	},  
	{  
		"id": 2,  
		"x": 0,  
		"y": 1,  
		"color": "#ffffff"  
	},  
	{  
		"id": 3,  
		"x": 0,  
		"y": 2,  
		"color": "#ffffff"  
	}  
]  
```
#### フィールド
なし

### [GET] <a id="questions">questions</a>

全ての課題と課題をクリアしたユーザの一覧を取得する

<使用例>

`GET http://api-atcolor.cps.im.dendai.ac.jp/v1/questions`
```
[  
	{  
		"id": 1,  
		"title": "can you GET?",  
		"description": "自分のプロフィールを取得する。",  
		"solvers": []  
	},  
	{  
		"id": 2,  
		"title": "can you POST?",  
		"description": "ユーザを作成する。",  
		"solvers": [  
			{  
				"id": 3,  
				"username": "cpstaro",  
				"twitter": null,  
				"language": null,  
				"total_point": 1  
			}  
		]  
	},  
	{  
		"id": 3,  
		"title": "can you PUT?",  
		"description": "自分のプロフィールを更新する。",  
		"solvers": []  
  }  
]  
```
#### フィールド
なし

### [GET] <a id="users/:id">users/:id</a>

#### フィールド
なし

### [PUT] <a id="putUsers">users</a>
作成したユーザのプロフィールを更新する

<使用例>

`PUT http://api-atcolor.cps.im.dendai.ac.jp/v1/users`
```
{  
	"id": 3,  
	"username": "cpstaro",  
	"twitter": "cps_lab",  
	"language": "python",  
	"total_point": 4,  
	"solved_questions": [  
		{  
			"id": 2,  
			"title": "can you POST?",  
			"description": "ユーザを作成する。"  
		},  
		{  
			"id": 3,  
			"title": "can you PUT?",  
			"description": "自分のプロフィールを更新する。"  
		}  
	]  
}  
```
#### フィールド
|名前|概要|
|:--|:--|
|twitter|twitterID|
|language|得意な言語|

#### ヘッダ
|名前|概要|
|:--|:--|
|authentication|登録時に生成したアクセストークン|

### [PUT] <a id="putPixels">pixels</a>
指定した座標に色を設定する

<使用例>

`PUT http://api-atcolor.cps.im.dendai.ac.jp/v1/pixels`
```
{  
	"id": 1,  
	"x": 0,  
	"y": 0,  
	"color": "blue"  
}  
```
#### フィールド
|名前|概要|
|:--|:--|
|x|x座標の値|
|y|y座標の値|
|color|色|

### ヘッダ
|名前|概要|
|:--|:--|
|authentication|登録時に生成したアクセストークン|
