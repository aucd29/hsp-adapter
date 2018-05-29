# hsp-adapter
[![Build Status](https://travis-ci.org/aucd29/hsp-adapter.svg?branch=master)](https://travis-ci.org/aucd29/hsp-adapter)
[![Release](https://jitpack.io/v/aucd29/hsp-adapter.svg)](https://jitpack.io/#aucd29/hsp-adapter)

hsp-adapter 는 mvvm 기반으로 작성되었으며 하나의 adapter 만으로 여러 형태의 recycler view 를 관리할 수 있습니다.


gradle 설정 
1. root level build.gradle 에 jitpack 정보를 추가 합니다. 
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. app level build.gradle 의 dependency 를 추가 합니다. 
```
dependencies {
	implementation 'com.github.aucd29:hsp-adapter:0.1.4'
}
```
