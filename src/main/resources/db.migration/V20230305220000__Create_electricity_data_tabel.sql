CREATE TABLE IF NOT EXISTS electricity_data (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  meter_id VARCHAR(100) NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  start_reading INTEGER NOT NULL,
  end_reading INTEGER NOT NULL,
  units_used INTEGER NOT NULL,
  rate_per_unit NUMERIC(19,2) NOT NULL,
  bill_amount NUMERIC(19,2) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
);