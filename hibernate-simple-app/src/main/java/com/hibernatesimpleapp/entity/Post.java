package com.hibernatesimpleapp.entity;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PostDetails details;

    //Getters and setters omitted for brevity

    public void setDetails(PostDetails details) {
        this.details = details;
        details.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostDetails getDetails() {
        return details;
    }
}
