import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.repository.AuthorRepository;
import com.example.BookManagementSystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public AuthorEntity createAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    public AuthorEntity updateAuthor(Long id, AuthorEntity updatedAuthor) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(updatedAuthor.getName());
                    author.setBio(updatedAuthor.getBio());
                    return authorRepository.save(author);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
    }

    @Transactional
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
    }
}