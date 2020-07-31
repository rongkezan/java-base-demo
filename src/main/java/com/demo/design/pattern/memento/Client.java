package com.demo.design.pattern.memento;

import lombok.Data;

// 守护者对象，保存游戏角色的状态
class Caretaker {
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}

@Data
class Memento {
	private int hp;
	private int mp;

	public Memento(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}
}

@Data
class GameRole {
	private int hp;
	private int mp;

	public Memento createMemento() {
		return new Memento(hp, mp);
	}

	public void recoverGameRoleFromMemento(Memento memento) {
		this.hp = memento.getHp();
		this.mp = memento.getMp();
	}

	public void display() {
		System.out.println("当前血量:" + this.hp + ",当前魔法:" + this.mp);
	}
}

public class Client {
	public static void main(String[] args) {
		GameRole gameRole = new GameRole();
		gameRole.setHp(100);
		gameRole.setMp(100);
		
		System.out.println("--- 战斗Boss前状态 ---");
		gameRole.display();
		
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(gameRole.createMemento());
		
		System.out.println("--- 战斗Boss后状态 ---");
		gameRole.setHp(30);
		gameRole.setMp(30);
		gameRole.display();

		System.out.println("--- 战斗结束 状态恢复 ---");
		gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
		gameRole.display();
	}
}
