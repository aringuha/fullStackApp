package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "suppliers")
public class Supplier {
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id;
    private @Column(name = "first_name") @NonNull String firstName;
    private @Column(name = "last_name") @NonNull String lastName;
    private @Column(name = "city") @NonNull String city;
    private @Column(name = "address") @NonNull String address;
    private @Column(name = "telephone") @NonNull String telephone;
}
