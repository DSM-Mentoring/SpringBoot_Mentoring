# 관계매핑 (@OneToOne @OneToMany @ManyToOne @ManyToMany (+) JoinColumn)

용어

- 방향

  - 단방향 관계 : 두 엔티티가 관계를 맺을 때 한쪽의 엔티티만 참조하고 있는 것을 의미
  - 양방향 관계 : 두 엔티티가 관계를 맺을 때 양쪽이 서로 참조하고 있는 것을 의미

  여기서 관계를 맺어주기만 하면 자동으로 양방향 관계가 되어서 서로 참조하지만, 객체지향 모델링에서는 구현하고자 하는 서비스에 따라 단방향관계인지, 양방향 관계인지 적절한 선택을 하여야 하는데, 어느 정도의 비즈니스에서는 단방향 관계에서만으로도 해결이 가능하기 때문에 양방향 관계를 꼭 해야하는 것은 아님. 사실 양방향 관계란 서로 다른 단방향 연관관계 2개를 애플리케이션 로직으로 잘 묶어서 양방향인 것처럼 보이게 할뿐, 양방향 연관관계는 존재하지 않는다고 할 수 있음

- 다중성

  관계에 있는 두 엔티티는 다음 중 하나의 관계를 갖음

  - ManyToOne - 다대일 (N : 1)
  - OneToMany - 일대다 (1 : N)
  - OneToOne - 일대다 (1 : N)
  - ManyToMany - 다대다 (N : N)

  어떤 엔티티의 중심으로 상대 엔티티00++++6를 바라 보느냐에 따라 다중서이 다름

**@OneToOne**

양방향이기 때문에 연관관계의 주인을 정해야 함. User클래스 코드 동일

앞서 단방향 @OneToOne관계를 설명하자면 FK를 소유한 자식 Entityr가 부모 Entity를 참조하는 형태에 대해서 살펴 보았음. 양방향 @OneToOne은 이와 크게 다르지 않으며 부모 Entity에서 자식 Entity에 대한 mappedBy 설정만 추가하면 됨. 이때 mappedBy 설정에는 자식 Entity에서 바라보는 부모 Entity의 변수이름을 지정

**@OneTomany**

연관관계의 주인을 정하는 방법은 mappedBy속성을 사용하는 것

- 주인은 mappedBy속성을 사용하지 않음
- 주인이 아니면 mappedBy 속성을 사용해서 속성의 값으로 연관관계의 주인을 정할 수 있음

이미 단방향 관계를 맺을 상채에서 단방향 연결을 해주었을때 이미 연결 해 주었기 때문에 양방향 관계가 성립

양방향이든, 단방향이든 테이블을 정의하는 SQL도 같음

**@ManyToOne**

예를 들어 한개의 블로그만 만들 수 있는 블로그 서비스를 개발하고 있다고 가정. 즉 유저와 블로그 1 : 1 관계라고 할 수 있음.

**@ManyToMany - 단방향**

- 단반향은 한 쪽의 엔티티가 상대 엔티티를 참조하고 있는 상태

단방향 @ManyToMany는 앞서 물리적으로는 존재할 수 없는 논리적인 관계이며 이를 위해 중간에 서로의 PK정보를 담아두는 맵핑 테이블을 사용해 @ManyToMany를 표현. 양방향 @ManyToMany는 이와 크게 다르지 않지만 문제는 서로의 Entity 가 동등한 위치를 가지고 있기 때문에 관계 설정 정보를 어디에 지정할 것 인가를 결정해야 한다는 점. 관계 설정 정보를 둘중 어디에 둘 것인지를 결정 했다면 반대쪽 Entity에 @ManyToMany어노테이션을 정의하고 mappedBy속성에 정의된 변수이름을 지정

**@JoinColumn**

- 데이터 모델링에서는 1 : N 관계만 설정해주면 자동으로 양방향 관계가 되기 때문에 어느 테이블에서든 join만 해주면 원하는 컬럼들을 가져올 수 있음
- JPA에서는 양방향 관계를 맺음으로써 해결 할 수 있음



