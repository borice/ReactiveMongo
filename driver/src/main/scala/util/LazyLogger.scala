/*
 * Copyright 2012-2013 Stephane Godbillon (@sgodbillon) and Zenexity
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactivemongo.util

object LazyLogger {
  import org.slf4j.{ LoggerFactory, Logger }

  /**
   * Returns the lazy logger matching the SLF4J `name`.
   *
   * @param name the logger name
   */
  def apply(name: String): LazyLogger =
    new LazyLogger(LoggerFactory getLogger name)

  final class LazyLogger(logger: Logger) {
    def trace(s: => String) { if (logger.isTraceEnabled) logger.trace(s) }
    def trace(s: => String, e: => Throwable) {
      if (logger.isTraceEnabled) logger.trace(s, e)
    }

    lazy val isDebugEnabled = logger.isDebugEnabled
    def debug(s: => String) { if (isDebugEnabled) logger.debug(s) }
    def debug(s: => String, e: => Throwable) {
      if (isDebugEnabled) logger.debug(s, e)
    }

    def info(s: => String) { if (logger.isInfoEnabled) logger.info(s) }
    def info(s: => String, e: => Throwable) {
      if (logger.isInfoEnabled) logger.info(s, e)
    }

    def warn(s: => String) { if (logger.isWarnEnabled) logger.warn(s) }
    def warn(s: => String, e: => Throwable) {
      if (logger.isWarnEnabled) logger.warn(s, e)
    }

    def error(s: => String) { if (logger.isErrorEnabled) logger.error(s) }
    def error(s: => String, e: => Throwable) {
      if (logger.isErrorEnabled) logger.error(s, e)
    }
  }
}
