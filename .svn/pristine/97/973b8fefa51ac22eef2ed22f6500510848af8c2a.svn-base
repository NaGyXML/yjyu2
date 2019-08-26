package com.yangjiayu;

import com.yangjiayu.entity.Index;
import com.yangjiayu.mapper.AddressMapper;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Yjyu2ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void dM5(){
		String sal = UUID.randomUUID().toString();
		String password = "1234";
		String md5Password= DigestUtils.md5DigestAsHex((password+sal).getBytes());
		System.out.println("sal"+sal
		);

//		81dc9bdb52d04dc20036dbd8313ed055md5;  1234原
//		ed2b1f468c5f915f3f1cf75d7068baaemd5;  1234原
		System.out.println(md5Password+"md5;  "+password+"原");
	}
	@Autowired
	AddressMapper addressMapper;
	@Test
	public void add111(){
		Date date = new Date();
		int rows= 0;
		List<Index> list = new ArrayList<>();
		int j =0;
		int length = 1000000;
		for (int i=0;i<length/400;i++){
			for (int k =0;k<400;j++,k++){
				Index index=new Index();
				index.setId(j);
				StringBuilder builder = new StringBuilder();
				Random random = new Random();
				long l = random.nextLong();
				String make = RandomString.make(20);
				index.setName(make+l);
				list.add(index);
			}
			int end=(1+i)*400;
			if (end>length) end=length;
			System.out.println(i);
			System.out.println(i*400+":::"+end);
			rows+= addressMapper.index(list.subList(i*400,end));
		}
		System.out.println("受影响行数"+rows);
		Date date2 = new Date();
		System.out.println(date2.getTime()-date.getTime());
	}
}
