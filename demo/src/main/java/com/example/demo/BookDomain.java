package com.example.demo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tbl_board")
public @Data class BookDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private int viewcnt;

	public BookDomain() {
	}

	public BookDomain(String title, String content, String writer, Timestamp regdate, int viewcnt) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		String log = String.format("bno=> %d, title=> %s, writer=> %s", bno, title, writer);
		return log;
	}
}
