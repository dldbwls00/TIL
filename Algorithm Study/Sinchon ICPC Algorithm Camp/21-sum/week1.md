# week1 :: c, c++ review

## c

* 포인터

```
int a = 3;
int* ptr = &a;
*ptr = 20;
printf("%d", a);
```
출력값은 20


## c++

* using namespace std; //실무에서는 사용하지 않음
* 시간초과 해결 (혼용불가)
* ```
ios::sync_with_stdio(false);
cin.tie(NULL);
cout.tie(NULL);
```



**컨테이너 container** : 임의 타입의 객체들을 보관하는 저장소

* 순차 컨테이너(sequence container) : 원소들이 순서대로 담김
  * ex) vector, list, string, deque 등
* 연관 컨테이너(associative container) : 원소들의 관계에 의해 저장위치가 바뀜
  * ex) set, map, multiset, multimap 등
* 컨테이너 어댑터(container adapte) : 기존 컨테이너의 일부 기능만 떼어내어 만듦
  * ex) stack, queue, priority_queue 등

* 컨테이너별로 유용한 함수 존재
