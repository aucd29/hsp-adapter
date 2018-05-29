
# hsp-adapter
[![Build Status](https://travis-ci.org/aucd29/hsp-adapter.svg?branch=master)](https://travis-ci.org/aucd29/hsp-adapter)
[![Release](https://jitpack.io/v/aucd29/hsp-adapter.svg)](https://jitpack.io/#aucd29/hsp-adapter)

hsp-adapter 는 mvvm 기반으로 작성되었으며 하나의 adapter 만으로 여러 형태의 recycler view 를 관리할 수 있다.
mvvm 은 주요 장점은 view 내에 data binding 을 xml 에서 처리하는 것으로, 기존 방식으로는 recycler view 에 해당하는
adapter 를 별도로 생성해야 했다.

hsp-adapter 는 data binding 을 xml 에 맞기고 일반적인 경우들에 대해서는 hsp-adapter 만으로 대응 할 수 있도록 설계 되었다.


## gradle 설정
1. root level build.gradle 에 jitpack 정보를 추가 합니다.
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. app level build.gradle 에 dependency 를 추가 합니다.
```
dependencies {
	implementation 'com.github.aucd29:hsp-adapter:0.1.4'
}
```

## 코드 작성

1. ViewModel 생성

hsp adapter 는 RecyclerView 연동을 위한 Base class 를 제공 하며 그 클래스는 com.hanwha.libhsp_adapter.arch.viewmodel.RecyclerViewModel 에 위치 한다.
사용자는 이 클래스를 상속 받은 후 recycler view 에 사용할 view model 과 adapter, 데이터를 설정할 수 있다.
```
public class TypeViewModel extends RecyclerViewModel<TypeItem> {
    public TypeViewModel(@NonNull Application application) {
        super(application);

        initData();
        initAdapter("type_recycler_item_title"); // adapter 의 인자 값은 recycler view 의 row 에 해당하는 xml 파일명을 전달하면 된다.
    }

    private void initData() {
        ArrayList<TypeItem> items = new ArrayList<>();
        items.add(new TypeItem(TypeItem.TYPE_SECTION, "SECTION"));
        items.add(new TypeItem(TypeItem.TYPE_TITLE, "버튼을 선택하여 데이터를 추가하세요"));

        setItems(items);
    }
}
```

2. xml 설정

recycler view 에 view model 에 등록되어 있는 adapter 와 item 을 선언 bindAdapter 와 bindItems 를 통해 선언 한다.
```
<android.support.v7.widget.RecyclerView
    android:id="@+id/recycler"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:orientation="vertical"
    app:layoutManager="android.support.v7.widget.LinearLayoutManager"
    app:bindAdapter="@{vmodel.adapter}"
    app:bindItems="@{vmodel.items}"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/add_title"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintBottom_toBottomOf="parent"
    />
```


ps. view model 에 items 를 갱신하면 hsp-adapter 가 내부적으로 화면을 갱신 해두록 설계 되어 있다.
