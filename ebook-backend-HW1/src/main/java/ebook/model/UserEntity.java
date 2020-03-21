package ebook.model;


import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue
    public Long userID;

    @Column(nullable = false, unique = true)
    public String username;

    @Column(nullable = true)
    public String avatar_path;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public boolean is_manager;

    @Column(nullable = false)
    public Integer state;

    public UserEntity(){
    }

    public void banUser() {
        this.state = -1;
    }

    public  void freeUser() {
        this.state = 1;
    }

}
