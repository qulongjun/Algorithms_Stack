package org.dataStructure.stack;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 * 猫狗队列
 * 猫Cat和狗Dog类继承Pet类
 * 
 * 实现一种猫狗队列：
 * 1.add：将猫或者狗放进队列
 * 2.pollAll：将猫或者狗按照进队列的顺序依次弹出
 * 3.pollDog：将狗按照进队列的顺序依次弹出
 * 4.pollCat：将猫按照进队列的顺序依次弹出
 * 5.isEmpty：检查队列中是否还有猫或者狗
 * 6.isDogEmpty：检查队列中是否还有狗
 * 7.isCatEmpty:检查队列中是否还有猫
 * @author 瞿龙俊
 *
 */
class PetEnterQueue {
	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		// TODO 自动生成的构造函数存根
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;
	}

	public long getCount() {
		return this.count;
	}

	public String getEnterPetType() {
		return this.pet.getPetType();
	}
}

public class DogCatQueue {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;

	public DogCatQueue() {
		// TODO 自动生成的构造函数存根
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}

	public void add(Pet pet) {
		String type = pet.getPetType();
		switch (type) {
		case "dog":
			this.dogQ.add(new PetEnterQueue(pet, this.count++));
			break;
		case "cat":
			this.catQ.add(new PetEnterQueue(pet, this.count++));
			break;
		default:
			throw new RuntimeException("类型异常");
		}
	}

	public Pet pollAll() {
		if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
			if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			} else {
				return this.catQ.poll().getPet();
			}
		} else {
			if (!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			} else {
				if (!this.catQ.isEmpty()) {
					return this.catQ.poll().getPet();
				} else {
					throw new RuntimeException("");
				}
			}
		}
	}

	public Dog pollDog() {
		if (!this.dogQ.isEmpty()) {
			return (Dog) this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("Dog不存在");
		}
	}

	public Cat pollCat() {
		if (!this.catQ.isEmpty()) {
			return (Cat) this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("Cat不存在");
		}

	}

	public boolean isEmpty() {
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}

	public boolean isDogEmpty() {
		return this.dogQ.isEmpty();
	}

	public boolean isCatEmpty() {
		return this.catQ.isEmpty();
	}

	@Test
	public void testQueue() throws Exception {
		add(new Dog("dog"));
		add(new Cat("cat"));
		add(new Dog("dog"));
		add(new Dog("dog"));
		add(new Cat("cat"));
		/*System.out.println(pollAll().getPetType());
		System.out.println(pollAll().getPetType());
		System.out.println(pollAll().getPetType());
		System.out.println(pollAll().getPetType());*/
		
		//System.out.println(pollCat().getPetType());
		//System.out.println(pollCat().getPetType());
		System.out.println(pollDog().getPetType());
		System.out.println(pollDog().getPetType());
	}
}

class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}

class Cat extends Pet {

	public Cat(String type) {
		super("cat");
		// TODO 自动生成的构造函数存根
	}

}

class Dog extends Pet {

	public Dog(String type) {
		super("dog");
		// TODO 自动生成的构造函数存根
	}

}
