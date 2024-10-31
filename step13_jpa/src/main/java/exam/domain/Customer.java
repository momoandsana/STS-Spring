package exam.domain;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity // jpa 가 관리하는 객체
@ToString
@DynamicUpdate // update 문이 나갈 때, 전체가 업데이트 되는 것이 아니라 바뀐 부분만 업데이트
//@DynamicInsert
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder // 나중에 build 하기 위해서 @NoArgsConstructor, @AllArgsConstructor 이거 필요함.
public class Customer {
	
	/**
	 * @GeneratedValue 는 자동으로 값을 넣어준다.
	 *  : strategy는 persistence provider가 엔티티의 기본키를 생성할때 사용해야하는 주키 생성 전략을 뜻함 (기본 AUTO)
	 *     
	 *  1) GenerationType.AUTO
	 *      : 데이터베이싀 벤더에 종속적이지 않고 hibernate 내부에서 기본키를 생성해서 할당해주는 방법 
	 *      엔티티가 2개여도 같은 키를 쓴다
	 *      : Oracle - SEQUENCE , MYSQL -AUTOINCREMENT , MSSQL  - IDENTITY
	 *       
	 *  2) GenerationType.SEQUENCE
	 *       : ORACLE 의 시퀀스 개념을 사용할때 
	 *       : 이 전략을 쓸때는 반드시   @SequenceGenerator 함께 사용
	 *  
	 *  3) GenerationType.TABLE
	 *      : 키를 생성할때 테이블이 직접 만들어서 사용하는 방법 
	 *  
	 *  4) GenerationType.IDENTITY
	 *       : MS-SQL, MY-SQL를 사용할때 
	 * */
   
	@Id // pk이다
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_id_seq")// generator 이름이랑 밑에 sequenceName은 같아야 함
	@SequenceGenerator(name="customer_seq",sequenceName="customer_id_seq",allocationSize=1)// name이랑 sequenceName 은 원래 같아야 함
	//@GeneratedValue(strategy=GenerationType.AUTO) 
	// hibernate에서 기본키 자동할당,Hibernate: create sequence hibernate_sequence start with 1 increment by  1
	private Long id;
	
	@Column(nullable=false,length=50,name="user_name",unique=true)
	private String userName;// 기본 null 
	
	//@Transient // 컬럼으로 만들지 않는다, 아무 어노테이션 없어도 컬럼으로 만들어진다(옵션이 없을 뿐)
	private int age;// not null
	
	@CreationTimestamp // insert 될 때 자동으로 날짜 등록-> timestamp 는 년월일+시분초
	private LocalDateTime insertDate;
	
	@UpdateTimestamp // update 될 때마다 자동으로 날짜 수정
	private LocalDateTime updateDate;
	
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	/*
	 * 자바에서 날짜는 Date
	 * LocalDateTime : Date 업그레이드 버전
	 */
}
