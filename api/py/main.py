#!/usr/bin/python
# -*- coding: utf-8 -*-

# main.py: server main script
#
# Author: Tomi.Mickelsson@iki.fi

# register REST API endpoints
import api_senfarming
import api_sentinelproc
import api_gee_proc
import api_ai_proc


import cron

import logging
log = logging.getLogger("main")

log.info("Running! http://localhost:8100")

from webutil import app
#if app.testing:
#    import werkzeug.debug
#    app.wsgi_app = werkzeug.debug.DebuggedApplication(app.wsgi_app, True)
    #uwsgi-daemon takes over the app...

