package dad.javafx.dogs.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.dogs.client.message.BreedsMessage;
import dad.javafx.dogs.client.message.ImageMessage;
import dad.javafx.dogs.client.message.MultiImageMessageURL;

public class DogsService {

	public DogsService() {

		// Cargamos nuestro objeto de mapeo -> para JSON
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}

	public List<String> listBreeds() throws DogServiceException {

		try {
			BreedsMessage breeds = Unirest
					.get("https://dog.ceo/api/breeds/list") // solicitamos mediante GET
					.asObject(BreedsMessage.class)
					.getBody(); // Obtenemos el cuerpo del mensaje como string

			if (!breeds.getStatus().equals("success"))
				throw new DogServiceException("Error retriving breeds list");

			return breeds.getMessage();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			throw new DogServiceException(e);
		}

	}

	public URL randomImageBreed(String breed) throws DogServiceException {
		
		try {
			ImageMessage image = 
					Unirest
						.get("https://dog.ceo/api/breed/"+breed+"/images/random") // solicitamos mediante GET
						.asObject(ImageMessage.class)
						.getBody();
			if (!image.isSuccess())
				throw new DogServiceException("Error retriving breeds list");

			return new URL(image.getMessage());
		} catch (MalformedURLException e) {
			throw new DogServiceException();
		} catch (UnirestException e) {
			throw new DogServiceException();
		}
	}
	
	public URL randomImage() throws DogServiceException{
		try {
			ImageMessage image = 
					Unirest
						.get("https://dog.ceo/api/breeds/image/random") // solicitamos mediante GET
						.asObject(ImageMessage.class)
						.getBody();
			if (!image.isSuccess())
				throw new DogServiceException("Error retriving breeds list");

			return new URL(image.getMessage());
		} catch (MalformedURLException e) {
			throw new DogServiceException();
		} catch (UnirestException e) {
			throw new DogServiceException();
		}
	}
	
	public List<URL> ImageBreeds(String breed) throws DogServiceException {
		try {
			/*ArrayList<URL> urList = new ArrayList<URL>();*/
			MultiImageMessageURL breeds = 
				Unirest
					.get("https://dog.ceo/api/breed/"+breed+"/images") // solicitamos mediante GET
					.asObject(MultiImageMessageURL.class)
					.getBody(); // Obtenemos el cuerpo del mensaje como string

			if (!breeds.getStatus().equals("success"))
				throw new DogServiceException("Error retriving breeds list");
			/*for(String msg : breeds.getMessage())
				urList.add(new URL(msg));*/
			return breeds.getMessage();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			throw new DogServiceException(e);
		}

	}
	
	public List<String> subBreeds(String breed) throws DogServiceException {
		try {
			BreedsMessage breeds = Unirest
					.get("https://dog.ceo/api/breed/"+breed+"/list") // solicitamos mediante GET
					.asObject(BreedsMessage.class)
					.getBody(); // Obtenemos el cuerpo del mensaje como string

			if (!breeds.getStatus().equals("success"))
				throw new DogServiceException("Error retriving breeds list");

			return breeds.getMessage();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			throw new DogServiceException(e);
		}
	}
	
	public static void main(String[] args) throws DogServiceException {
		DogsService service = new DogsService();

		System.out.println(service.listBreeds());
		System.out.println(service.randomImageBreed("akita"));
		System.out.println(service.randomImage());
		System.out.println(service.ImageBreeds("akita"));
		System.out.println(service.subBreeds("bulldog"));
	}

}
