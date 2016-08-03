package org.dataStructure.stack;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 * è������
 * èCat�͹�Dog��̳�Pet��
 * 
 * ʵ��һ��è�����У�
 * 1.add����è���߹��Ž�����
 * 2.pollAll����è���߹����ս����е�˳�����ε���
 * 3.pollDog���������ս����е�˳�����ε���
 * 4.pollCat����è���ս����е�˳�����ε���
 * 5.isEmpty�����������Ƿ���è���߹�
 * 6.isDogEmpty�����������Ƿ��й�
 * 7.isCatEmpty:���������Ƿ���è
 * @author ������
 *
 */
class PetEnterQueue {
	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵĹ��캯�����
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
			throw new RuntimeException("�����쳣");
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
			throw new RuntimeException("Dog������");
		}
	}

	public Cat pollCat() {
		if (!this.catQ.isEmpty()) {
			return (Cat) this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("Cat������");
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
		// TODO �Զ����ɵĹ��캯�����
	}

}

class Dog extends Pet {

	public Dog(String type) {
		super("dog");
		// TODO �Զ����ɵĹ��캯�����
	}

}
