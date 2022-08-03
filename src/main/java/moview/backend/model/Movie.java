package moview.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document("movie")
public class Movie {
        @Id
        private String id;
        private Boolean isMovie;
        private String name;
        private Double price;
        private String category;
        private String synopsis;
        private String smallPosterLocation;
        private String largePosterLocation;
        private Double rentalPrice;
        private Double purchasePrice;
        private Boolean isFeatured;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Boolean getIsMovie() {
			return isMovie;
		}
		public void setIsMovie(Boolean isMovie) {
			this.isMovie = isMovie;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSynopsis() {
			return synopsis;
		}
		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}
		public String getSmallPosterLocation() {
			return smallPosterLocation;
		}
		public void setSmallPosterLocation(String smallPosterLocation) {
			this.smallPosterLocation = smallPosterLocation;
		}
		public String getLargePosterLocation() {
			return largePosterLocation;
		}
		public void setLargePosterLocation(String largePosterLocation) {
			this.largePosterLocation = largePosterLocation;
		}
		public Double getRentalPrice() {
			return rentalPrice;
		}
		public void setRentalPrice(Double rentalPrice) {
			this.rentalPrice = rentalPrice;
		}
		public Double getPurchasePrice() {
			return purchasePrice;
		}
		public void setPurchasePrice(Double purchasePrice) {
			this.purchasePrice = purchasePrice;
		}
		public Boolean getIsFeatured() {
			return isFeatured;
		}
		public void setIsFeatured(Boolean isFeatured) {
			this.isFeatured = isFeatured;
		}
		@Override
		public String toString() {
			return "Movie [id=" + id + ", isMovie=" + isMovie + ", name=" + name + ", price=" + price + ", category="
					+ category + ", synopsis=" + synopsis + ", smallPosterLocation=" + smallPosterLocation
					+ ", largePosterLocation=" + largePosterLocation + ", rentalPrice=" + rentalPrice
					+ ", purchasePrice=" + purchasePrice + ", isFeatured=" + isFeatured + "]";
		}
		public Movie() {
			super();
		}


}