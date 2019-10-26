# CrabTest
Crabアプリの開発に向けたテスト用のアプリケーション

## 概要


## deploygateを用いた実機確認
https://docs.deploygate.com/v1.1/docs/gradle-plugin

アプリはGoogle PlayやApp storeで一般に公開されますが、開発用に使う際はDeployGateというカジュアルに開発中のアプリを配布できるサービスを使います。
androidstudioのエミュレータ(PCの中に仮想のスマホを作って、画面上で操作できるようにするものです)を使うこともできますが、エミュレータを介してインターネットに繋げる設定が面倒+手元で試せないため、これを使うのがおすすめです。

## Retrofit2を用いてAPIを叩く
https://github.com/square/retrofit

今回、AWS API Gatewayに生やしたAPIを叩く(GET、POSTメソッド)を使うため、Retrofit2を使う方法とAWS API Gatewayを使ったAPIの利用について紹介します。
https://qiita.com/wakiwaki/items/82f8dfff927ca5b9522f
上記記事のように、Android studioにRetrofit2を導入して、RakutenActivity・activity_rakuten.xmlを使って表示させています。
@get('{APIのURL}')、@post('{APIのURL}')を書くだけでAPIを叩く準備をしてくれるという優れものです。

## AWS API gatewayからダウンロードしたAndroid/iOS向けのSDKを用いてAPIを叩く
https://dev.classmethod.jp/cloud/aws/api-gateway-with-android/


## Kotlin/Nativeを用いてiOS用のアプリに移植する


