import https from "./Https-common";

class TestComponent {  
     
    getAll() {  
        return https.get("/api/korisnici");  
      }  
        
}  
export default new TestComponent();  