ALTER TABLE TRANSACTIONS
ADD CONSTRAINT FK_TRANSACTIONS
FOREIGN KEY (ACCT_ID) REFERENCES BANKACCOUNT(ACCOUNT_USER);
/