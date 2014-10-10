package model;

import java.io.UnsupportedEncodingException;

public class DetailAction {
	String name="";
	static int p;
	String isbn;
	String publisher;
	String publishdate;
	String price;
	String age;
	String authorname;
	String country;
	public String getName()
	{
		return name;
	}
	public void setName(String name) throws UnsupportedEncodingException
	{
		this.name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	}
	public String getIsbn()
	{
		isbn=search.ISBN.get(p);
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn=search.ISBN.get(p);
	}
	public String getPublisher()
	{
		publisher=search.Publisher.get(p);
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher=search.Publisher.get(p);
	}
	public String getPublishdate()
	{
		publishdate=search.PublishDate.get(p);
		return publishdate;
	}
	public void setPublishdate(String publishdate)
	{
		this.publishdate=search.PublishDate.get(p);
	}
	public String getPrice()
	{
		price=search.Price.get(p);
		return price;
	}
	public void setprice(String publishdate)
	{
		this.price=search.Price.get(p);
	}
	public String getAge()
	{
		age=search.age;
		return age;
	}
	public void setAge(String age)
	{
		this.age=search.age;
	}
	public String getCountry()
	{
		country=search.country;
		return country;
	}
	public void setCountry(String country)
	{
		this.country=search.country;
	}
	public String getAuthorname()
	{
		authorname=search.author;
		return authorname;
	}
	public void setAuthorname(String authorname)
	{
		this.authorname=search.author;
	}
	public String execute() {
		
		p=search.Title.indexOf(name);
		
		return "show";
	}
}
