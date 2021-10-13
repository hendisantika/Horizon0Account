-- ALTER TABLE account change status account_status VARCHAR (25);
ALTER TABLE account RENAME COLUMN status TO account_status;
