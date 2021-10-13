ALTER TABLE account
    ADD created_at TIMESTAMP DEFAULT now();
ALTER TABLE account
    ADD deleted_at TIMESTAMP DEFAULT now();
