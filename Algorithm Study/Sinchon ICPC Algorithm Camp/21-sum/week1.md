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

<br/><br/>

## c++

* using namespace std; //실무에서는 사용하지 않음
* 시간초과 해결 (혼용불가)
```
ios::sync_with_stdio(false);
cin.tie(NULL);
cout.tie(NULL);
```
<br/>

### **컨테이너 container** : 임의 타입의 객체들을 보관하는 저장소

* 순차 컨테이너(sequence container) : 원소들이 순서대로 담김
  * ex) vector, list, string, deque 등
* 연관 컨테이너(associative container) : 원소들의 관계에 의해 저장위치가 바뀜
  * ex) set, map, multiset, multimap 등
* 컨테이너 어댑터(container adapte) : 기존 컨테이너의 일부 기능만 떼어내어 만듦
  * ex) stack, queue, priority_queue 등

* 컨테이너별로 유용한 함수 존재

<br/>

### **알고리즘 algorithm** : 컨테이너의 원소들을 조작할 수 있는 함수들의 모임
* 반복자 또는 포인터로 작업할 원소를 가리킴
* [first, last)
* ex) 검색, 정렬, 수정, 개수 세기 등
* 참고 (https://en.cppreference.com/w/cpp/algorithm)

<br/>

### **벡터 vector**
```#include <vector>```
* 순차 컨테이너
* vector<type> v;
* 자동으로 메모리가 할당되는 배열(동적 배열) : 크기를 변수로 지정 가능
* v.push_back() / v.pop_back()
* c언어의 배열과 같이 random access가 가능함, 배열보다 조금 더 시간과 메모리를 사용
* **멤버 함수**
* undefined behavior : 인덱스를 벗어나는 경우
<br/><br/>
* vector<type> v(n, m) : 크기가 n인 벡터를 모두 m으로 초기화
* v.assign(n, m) : 이미 선언된 벡터의 크기를 n으로 만들고 모두 m으로 초기화
* v.size() : 벡터의 크기 반환
* v.empty() : 비어있으면 true, 비어있지 않으면 false 반환
* begin() / end() / rbegin() / rend() : 반복자
 <br/>
 
 
|---|---|---|---|---|
||v.begin()|||v.end()|
||[0]|[1]|[2]||
|v.rend()|||v.rbegin()||
