CREATE TABLE IF NOT EXISTS invoice (
  id BIGSERIAL PRIMARY KEY,
  description VARCHAR(255),
  total_amount BIGINT,
  date_issued DATE,
  due_date DATE,
  paid_date DATE,
  is_paid BOOLEAN,
  payment_method VARCHAR(255),
  user_id BIGINT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);