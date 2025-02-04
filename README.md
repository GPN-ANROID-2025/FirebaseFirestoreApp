# FirebaseFirestoreApp
Firebase Firestore Setup and Usage in Java (Android)  

1. **Set Up Firebase in Your Android Project**  

Step 1: Create a Firebase Project  
- Go to the Tools Menu In Android => Firebase => Cloud Firestore => Get Started with cloud firestore [Java]
- Click on "Connect"  =>   Add cloud firestore to your app



2. **Initialize Firestore in Your Android App**  

In your `MainActivity.java` or another suitable class, import Firestore and initialize it:  

```java
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();
    }
}
```

3. **Add Data to Firestore**  

To add data to a collection:  

```java
Map<String, Object> user = new HashMap<>();
user.put("name", "John Doe");
user.put("age", 25);
user.put("email", "johndoe@example.com");

db.collection("users")
    .add(user)
    .addOnSuccessListener(documentReference -> 
        Log.d("Firestore", "Document added with ID: " + documentReference.getId()))
    .addOnFailureListener(e -> 
        Log.w("Firestore", "Error adding document", e));
```

4. **Retrieve Data from Firestore**  

To get all documents from a collection:  

```java
db.collection("users")
    .get()
    .addOnCompleteListener(task -> {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Log.d("Firestore", document.getId() + " => " + document.getData());
            }
        } else {
            Log.w("Firestore", "Error getting documents.", task.getException());
        }
    });
```

5. **Update Data in Firestore**  

To update an existing document:  

```java
DocumentReference userRef = db.collection("users").document("user_id");

userRef.update("age", 26)
    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Document updated successfully"))
    .addOnFailureListener(e -> Log.w("Firestore", "Error updating document", e));
```

6. **Delete Data from Firestore**  

To delete a document:  

```java
db.collection("users").document("user_id")
    .delete()
    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Document deleted"))
    .addOnFailureListener(e -> Log.w("Firestore", "Error deleting document", e));
```

This guide provides the basic setup and operations for Firebase Firestore in an Android app using Java. Let me know if you need additional details.
