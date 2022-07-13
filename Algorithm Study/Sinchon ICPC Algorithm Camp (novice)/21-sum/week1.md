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
 
||v.begin()|||v.end()|
|---|---|---|---|---|
||[0]|[1]|[2]||
|v.rend()|||v.rbegin()||

* front() / back() : 원소
* push_back(m) / pop_back(m) : 뒤에 추가 / 뒤에서 빼기
* 벡터의 모든 원소를 훑는 코드 예시 (반복자 이용)
 ```
#include <iostream>
#include <vector>
using namespace std;

int main(){
    //1
    vector<int> v={1,2,3}
    for (int i=0; i<v.size(); i++)	cout << v[i];
    
    //2
    vector<int>::iterator it;
    for (it=v.begin(); it!=v.end(); it++)	cout << *it;
    
    //3
   	for (int i=(int)v.size()-1; i>=0; i--)	cout << v[i];
   
    //4
    vector<int>::reverse_iterator it2;
    for (it2=v.begin(); it2!=v.rend(); it2++)	cout<< *it2;
    
    return 0;
}
```
* 넷 다 같은 표현이지만 1이 가장 직관적이고 편리함
* resize(n) / resize(n,m) : 원래보다 작아지면 뒤부터 삭제, 많지면 m으로 초기화
* insert(iter, m) / insert(iter, k, m) : iter는 반복자, iter위치에 k개의 m을 삽입. 중간에 삽입하면 뒤의 원소를 한 칸씩 밀어야 하므로 시간이 오래 걸림
* erase(iter), erase(start, end) : start부터 end까지 원소 삭제
 
<br/>
 
### pair
```#include <utility>```
* vector, algorithm 헤더에 이미 포함됨
* 두 객체를 하나의 객체로 묶어 사용할 수 있게 해주는 클래스 (순서쌍, 좌표평면 위의 점 등)
* pair<type1, type2> p;
* first, second로 원소 접근 가능
* 연산자 사용 가능 (ex. (2,3) < (2,4)) : first 먼저 비교
* pair 이용 예시
```
                               #include <iostream>
#include <utility>
using namespace std;

int main(){
	pair<int, int> p1, p2, p3;
    
    p1.first=2;
    p1.second=1;
    
    p2=make_pair(3,1);
    
    p3={0,1}; //since c++11
    
 	if (p1<p2) cout << "<";
    else if (p1==p2)	cout << "same";
    else	cout << ">";
    return 0;
}
```
```pair<int, pair<int, int>> p; p={1, {2, 3}};```

 <br/>
 
### 알고리즘 algorithm
```#include <algorithm>```
* min(a, b) / max(a, b) //c++14 부터는 괄호 안에 여러 개의 원소를 넣을 수 있음
* *min_element(arr, arr+5) / *max_element(v.begin(), v.end()) : 배열, 벡터에서, *이 붙었으므로 위치가 아니라 값 자체를 반환
* swap(a, b) : 벡터도 사용 가능
* reverse(v.begin(), v.end())

 <br/> <br/> <br/>

# how to study
1. c언어로 풀 수 있는 문제를 푼다
2. c++로 작성한 다른 사람의 코드를 본다
3. 처음 보는데 여러 사람들이 공통적으로 쓴 부분을 구글링
-> 학습의 속도는 느리지만 불필요한 학습이 줄고 자주 사용하는 것 위주로 공부 가능
	
 <br/> <br/>
	
# 공부하면 좋은 것들: 필요에 따라서
* 반복자 interator
* container: set, map, multiset, multimap, string
* algorithm: next_permutation(여러 개의 원소를 일렬로 배열하는 모든 경우), unique(중복된 원소 제거), copy, fill, find
	
 <br/> <br/> <br/>
# 과제
* 출석문제
	
15552 빠른 A+B : 브론즈2
	
10804 카드 역배치 : 브론즈2
	
1158 요세푸스 문제 : 실버5
	
1547 공 : 브론즈3

<br/>

* 연습문제(기초 cpp 연습)
	
1008 A/B : 브론즈4
	
2993 세 부분 : 실버5
	
9093 단어 뒤집기 : 브론즈1
	
2346 풍선 터트리기 : 실버3
	
