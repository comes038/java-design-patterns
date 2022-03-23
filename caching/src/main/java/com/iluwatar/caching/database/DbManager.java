/*
*The MIT License
*Copyright © 2014-2021 Ilkka Seppälä
*
*Permission is hereby granted, free of charge, to any person obtaining a copy
*of this software and associated documentation files (the "Software"), to deal
*in the Software without restriction, including without limitation the rights
*to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*copies of the Software, and to permit persons to whom the Software is
*furnished to do so, subject to the following conditions:
*
*The above copyright notice and this permission notice shall be included in
*all copies or substantial portions of the Software.
*
*THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
*THE SOFTWARE.
*/

package com.iluwatar.caching.database;

import com.iluwatar.caching.UserAccount;

/**
 * <p>DBManager handles the communication with the underlying data store i.e.
 * Database. It contains the implemented methods for querying, inserting,
 * and updating data. MongoDB was used as the database for the application.</p>
 */
public interface DbManager {
  /**
   * Connect to DB.
   */
  void connect();

  /**
   * Disconnect from DB.
   */
  void disconnect();

  /**
   * Read from DB.
   *
   * @param userId {@link String}
   * @return {@link UserAccount}
   */
  UserAccount readFromDb(String userId);

  /**
   * Write to DB.
   *
   * @param userAccount {@link UserAccount}
   * @return {@link UserAccount}
   */
  UserAccount writeToDb(UserAccount userAccount);

  /**
   * Update record.
   *
   * @param userAccount {@link UserAccount}
   * @return {@link UserAccount}
   */
  UserAccount updateDb(UserAccount userAccount);

  /**
   * Update record or Insert if not exists.
   *
   * @param userAccount {@link UserAccount}
   * @return {@link UserAccount}
   */
  UserAccount upsertDb(UserAccount userAccount);
}
